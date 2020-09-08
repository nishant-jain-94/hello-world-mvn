job('build-and-test-project') {
    scm {
        git {
            remote {
                github('kubix-io-ltd/hello-world-java-jenkins-dsl', 'https')
                credentials('GithubCredentials')
            }
        }
    }
    jdk('jdk-11')
    steps {
        maven {
            mavenInstallation('maven3')
            goals('compile')
            goals('package')
            goals('test')
        }
    }
    publishers {
        archiveJunit("target/**/surefire-reports/*.xml")
    }
}