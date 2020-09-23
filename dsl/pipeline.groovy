job('build-and-test-project') {
    scm {
        git {
            remote {
                github('nishant-jain-94/hello-world-mvn', 'https')
                credentials('GithubCredentials')
            }
        }
    }
    jdk('openjdk-11')
    steps {
        maven {
            mavenInstallation('maven3')
            goals('compile')
            goals('package')
            goals('test')
        }
        openshift.withClusters('my-ocp-cluster') {
            openshift.withProject('hello-world') {
                openshift.raw("new-app fabric8/s2i-java~https://github.com/nishant-jain-94/hello-world-mvn.git")
                openshift.raw("oc expose svc/hello-world-mvn --port=8080")
            }
        }
    }
    publishers {
        archiveJunit("target/**/surefire-reports/*.xml")
    }
}