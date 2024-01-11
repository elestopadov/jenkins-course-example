pipeline {
    agent any
    parameters {
        string(name: 'FIRST_NAME', defaultValue: 'Ivan',
                description: 'This is your name')
        string(name: 'LAST_NAME', defaultValue: 'Ivanov',
                description: '')
        text(name: 'MESSAGE', defaultValue: '',
                description: 'Enter some information about the news')
        booleanParam(name: 'DO_IT', defaultValue: true,
                description: '.....')
        choice(name: 'CHOICE', choices: ['one', '2', 'Three'],
                description: 'Pick something')
        password(name: 'PASSWORD', defaultValue: 'SECRET',
                description: 'Enter a password')
    }
    stages {
        stage('Example') {
            steps {
                echo "Hello ${params.FIRST_NAME}"

                echo "Biography: ${params.LAST_NAME}"

                echo "Toggle: ${params.DO_IT}"

                echo "Choice: ${params.CHOICE}"

                echo "Password: ${params.PASSWORD}"
            }
        }
    }
}
