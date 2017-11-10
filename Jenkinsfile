node {
  echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
  
  // Mark the code checkout 'stage'....
  stage 'Checkout'

  // Checkout code from repository
  checkout scm

  stage 'Build'

  //branch name from Jenkins environment variables
  echo "Current branch is: ${env.BRANCH_NAME}"

  def flavor = flavor(env.BRANCH_NAME)
  echo "Building flavor ${flavor}"

  //build your gradle flavor, passes the current build number as a parameter to gradle
  //sh "./gradlew clean assemble${flavor}Debug -PBUILD_NUMBER=${env.BUILD_NUMBER}"
}