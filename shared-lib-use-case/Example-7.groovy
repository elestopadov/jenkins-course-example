pipeline {
    agent any
    libraries {
        lib('test-library')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Pipeline example-7'
                script {
                    def string_content = libraryResource 'org/json/user.json'
                    useJson.readJson(string_content, this)
                }
            }
        }
    }
}
