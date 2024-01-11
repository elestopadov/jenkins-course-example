
def getInfoGit(String url) {
    println "URL: ${url}"
}

def loopMethod() {
    for (i in 0..5) {
        println i
    }
}

def getInfoGitBranch(String url) {
    def command = "git ls-remote -h ${url}"
    def result = sh(script: command, returnStdout: true)

    String[] listStr = result.split("\n")
    for (int i = 0; i < listStr.length; i++) {
        echo "$i: " + listStr[i]
    }
}

return this
