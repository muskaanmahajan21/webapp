pipeline {
  agent any   // runs on any available node; change to label if needed

  stages {
    stage('Checkout SCM') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        bat 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      steps {
        bat 'mvn test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Sonar-Report') {
      steps {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
          bat '''
            mvn sonar:sonar ^
              -Dsonar.host.url=http://localhost:9000 ^
              -Dsonar.token=%SONAR_TOKEN% ^
              -Dsonar.projectKey=webapp1 ^
              -Dsonar.projectName=Webapp1 ^
              -Dsonar.sourceEncoding=UTF-8
          '''
        }
      }
    }
  }
}
