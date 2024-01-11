pipeline {
    agent any
    triggers {
        cron('H */8 * * 1-5')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Hello World(cron)'
            }
        }
    }
}
