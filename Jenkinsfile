pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'openjdk-11'
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