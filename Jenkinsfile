pipeline {
    agent any
    stages {
        stage('Build') {
            jdk('openjdk-11')
            steps {
                maven {
                    mavenInstallation('maven3')
                    goals('compile')
                    goals('package')
                    goals('test')
                } 
            }
        }
    }
}