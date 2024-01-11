@Library('test-library') import io.example.Person

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Hello Pipeline'
                script {
                    def person = new Person('Valera', 27)
                    echo person.getAbout()
                }
            }
        }
    }
}
