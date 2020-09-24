pipeline {
    agent any
    tools {
        maven '3.3.9'
        jdk 'jdk11'
    }
    stages {
        stage('Build') {
            jdk('openjdk-11')
            steps {
                sh 'mvn test'
                sh 'mvn build'
            }
        }
    }
}