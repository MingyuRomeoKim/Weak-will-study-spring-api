pipeline {
    agent any

    triggers {
        // This will trigger the pipeline on every push to the repository
        pollSCM('* * * * *')
    }

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
                // Make sure to adjust the path to the JAR file according to your project structure
                // sh 'nohup java -jar build/libs/*SNAPSHOT.jar > /dev/null 2>&1 &'
                // sh 'nohup java -jar build/libs/*SNAPSHOT.jar > nohup.out 2>&1 &'
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