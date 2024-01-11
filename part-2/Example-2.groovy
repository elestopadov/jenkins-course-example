pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                echo 'Helo Pipeline'
            }
        }
        stage('Test') {
            agent any
            steps {
                echo 'Test'
            }
        }
    }
}
