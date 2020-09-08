job('build-and-test-project') {
    scm {
        git('https://github.com/kubix-io-ltd/hello-world-java-jenkins-dsl')
    }
    jdk('jdk-1.11')
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