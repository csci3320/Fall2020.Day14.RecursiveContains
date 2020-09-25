import java.util.HashMap;

public class Graph<T> {

    HashMap<HeroType, GraphNode<T>> allHeroes;
    
    public Graph(){
        allHeroes = new HashMap<HeroType, GraphNode<T>>();

        HeroType awesomeStudent = new HeroType();
        GraphNode<T> pathToGraduation = new GraphNode<T>();
        allHeroes.put(awesomeStudent, pathToGraduation);

        //Later

        GraphNode<T> myPath = allHeroes.get(awesomeStudent); //pathToGraduation
    }
   



}