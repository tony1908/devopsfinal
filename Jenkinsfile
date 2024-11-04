pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'docker build -f Dockerfile.test -t toony1908/devopsfinaltests .'
            }
        }
        stage('Build') {
            steps {
                sh 'docker build -f Dockerfile -t toony1908/devopsfinal .'
            }
        }
    }
}