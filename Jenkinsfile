pipeline {
    agent any

    //triggers {
    //    // This will trigger the pipeline on every push to the repository
    //    pollSCM('H * * * *')
    //}

    stages {
        stage('Checkout') {
            steps {
                // Checking out the code from the repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run the gradle build
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the application...'
                // Run tests (if any)
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application
                sh '''
                cp build/libs/*SNAPSHOT.jar ~/deploy/
                echo $(date +"%Y-%m-%d %H:%M:%S") > ~/deploy/deploy.txt
                '''

            }
        }
    }

    post {
        always {
            // Clean up the workspace to free up space
            cleanWs()
        }
    }
}