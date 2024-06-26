pipeline {
    agent any
    stages {
        stage ('SCM checkout'){
            steps{
                retry(3){
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MalinduDissanayaka/3909-dissanayaka']])
                }
            }
      
        }
        stage('build docker'){
            steps {
                sh 'docker build -t Malindu3909/3909-dissanayaka .'
            }
        
        }
         stage('run'){
            steps{
                sh 'docker run -d -p 5000:3000 Malindu3909/3909-dissanayaka'
         }
         }
         stage('show running containners'){
      steps{
        sh 'docker ps'
      }
    }
    }
}
