def call() {
    withCredentials([string(credentialsId: 'NVD_API_KEY', variable: 'NVD_API_KEY')]) {
        dependencyCheck(
            additionalArguments: "--scan ./ --nvdApiKey ${NVD_API_KEY}",
            odcInstallation: 'OWASP'
        )
    }
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
