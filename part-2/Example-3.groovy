pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                echo 'testing...'
            }
        }
        stage('Build') {
            steps {
                echo 'build building'
                sh 'ls -l'
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploy to container'
            }
        }
    }
}
