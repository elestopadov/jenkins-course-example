pipeline {
    agent any
    stages {
        stage('Example') {
            input {
                message 'Will you continue?'
                ok 'Yes, we should.'

                parameters {
                    choice(
                        name: 'CHOICE',
                        choices: ['Yes', 'No'],
                        description: 'yes or no?'
                    )
                }
            }
            steps {
                echo "Your selected: ${CHOICE}"
            }
        }
    }
}
