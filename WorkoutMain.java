
public class WorkoutMain {
    public static void main(String[] args) {
        new WorkoutMain();
    }

    public WorkoutMain(){
        Graph<Question> workoutQuestions = new Graph<Question>();

        GraphNode<Question> rootQuestion = new GraphNode<Question>();
        GraphNode<Question> chooseGoal = new GraphNode<Question>();
        GraphNode<Question> goalChoosingGuide = new GraphNode<Question>();
        
        rootQuestion.Value.question = "Do you currently have any fitness goals?";
        
        AnswerGraphNodePair hasGoal = new AnswerGraphNodePair();
        hasGoal.answer = "yes";
        AnswerGraphNodePair noGoal = new AnswerGraphNodePair();
        noGoal.answer = "no";

        rootQuestion.Value.answers.add(hasGoal);
        rootQuestion.Value.answers.add(noGoal);


    }

}