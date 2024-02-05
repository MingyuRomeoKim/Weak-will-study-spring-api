pipeline {
    agent any
    stages {
        stage('git clone') {
            // Git clone from the specified repository and branch
            git branch: 'main', url: 'https://github.com/MingyuRomeoKim/Weak-will-study-spring-api.git'
        }
        stage('build') {
            steps {
                // Run the gradle build
                sh './gradlew clean bootJar'
            }
        }
        stage('test') {
            steps {
                echo 'testing the application...'
            }
        }
        stage('deploy') {
            steps {
                // Run the built JAR file in the background
                sh 'nohup java -jar build/libs/*SNAPSHOT.jar > nohup.out 2>&1 &'
            }
        }
    }
}