pipeline {
    agent {
        label 'master'
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
//         stage('Sonar-Report') {
//             steps {
//             sh 'mvn sonar:sonar \
//   -Dsonar.projectKey=jenkins_project \
//   -Dsonar.host.url=http://localhost:9000 \
//   -Dsonar.login=5f09ded7e5db4d0ea0dcfd937c181af706e60475'
//             }
//         }
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

        pipeline {
    triggers {
        cron('H 10 * * *') // Runs daily at 10 AM
    }

    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Scheduled build triggered at 10 AM'
            }
        }
    }
}

        stage('Sonar-Report') {
            steps {
                bat 'mvn clean install sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.analysis.mode=publish'
            }
        }
    }
}


pipeline {
    triggers {
        pollSCM('H/15 * * * *') // Polls every 15 minutes
    }

    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Polling SCM for changes...'
            }
        }
    }
}

