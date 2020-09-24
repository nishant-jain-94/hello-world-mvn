pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'openjdk-11'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn test'
                sh 'mvn install'
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    withEnv(["PATH+OC=${tool 'oc'}"]) {
                        openshift.withCluster('my-ocp-cluster') {
                            openshift.withProject('hello-world') {
                                openshift.raw('get pods')
                                openshift.raw("new-app fabric8/s2i-java~https://github.com/nishant-jain-94/hello-world-mvn.git")
                                openshift.raw("oc expose svc/hello-world-mvn --port=8080")
                            }
                        }
                    }
                }
            }
        }
    }
}