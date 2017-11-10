node {
  // Mark the code checkout 'stage'....
  stage 'Checkout'

  // Checkout code from repository
  checkout scm

  stage 'Build'

  //branch name from Jenkins environment variables
  echo sh(returnStdout: true, script: 'env')

  //build your gradle flavor, passes the current build number as a parameter to gradle
  //sh "./gradlew clean assemble${flavor}Debug -PBUILD_NUMBER=${env.BUILD_NUMBER}"
}