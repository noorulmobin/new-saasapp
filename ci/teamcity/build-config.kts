import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

version = "2022.1"

project {
    id = "HelloWorld_Project"
    name = "Hello World Node.js Project"
    
    // VCS Root - Git repository configuration
    vcsRoot(GitVcsRoot {
        id = "Git_Repository"
        name = "Git Repository"
        url = "https://github.com/your-username/hello-world-app.git"
        branch = "refs/heads/main"
    })
    
    // Build Configuration
    buildType {
        id = "HelloWorld_Build_And_Test"
        name = "Build and Test"
        description = "Builds and tests the Hello World Node.js application"
        
        vcs {
            root(GitVcsRoot)
            cleanCheckout = true
        }
        
        steps {
            // Install dependencies
            script {
                name = "Install Dependencies"
                scriptContent = """
                    npm ci
                """.trimIndent()
            }
            
            // Run tests
            script {
                name = "Run Tests"
                scriptContent = """
                    npm test
                """.trimIndent()
            }
            
            // Build Docker image
            script {
                name = "Build Docker Image"
                scriptContent = """
                    docker build -t hello-world-app:${build.number} .
                    docker tag hello-world-app:${build.number} hello-world-app:latest
                """.trimIndent()
            }
        }
        
        triggers {
            vcs {
                branchFilter = "+:main"
                groupCheckinsByCommitter = true
                perCheckinTriggering = true
            }
        }
        
        requirements {
            contains("env.OS", "Linux")
        }
    }
} 