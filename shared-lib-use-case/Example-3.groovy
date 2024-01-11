@Library('test-library') import io.example.ExampleTool

def exTool = new ExampleTool(env, steps)
node {
    exTool.printEnv()
}
