pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'check...'

                script {
                    def servers = ['dev', 'test']
                    if (servers[0].equals('dev')) {
                        println 'This is DEV'
                    } else {
                        println "It's not dev..."
                    }
                }
            }
        }
    }
}
