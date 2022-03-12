import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamMapExample {

    public static void main(String[] args) {

        Article forLoop = new Article(
                1,
                "For Loop Java Tutorial",
                "Dimitris Tasios"
        );

        Article interfaceTutorial = new Article(
                2,
                "Java Interface Tutorial",
                "Georgios - Nikolaos Palaiologopoulos"
        );

        Article generics = new Article(
                3,
                "Java Generics Tutorial",
                "Ignis Dei"
        );

        Article mathRandom = new Article(
                4,
                "Math.random Java Tutorial",
                "Georgios - Nikolaos Palaiologopoulos"
        );


        List<Article> articles = Arrays.asList(forLoop, interfaceTutorial, generics, mathRandom);

        mapToTitle(articles).forEach(System.out::println);
        mapToTitleAlternate(articles).forEach(System.out::println);

        mapToTitleAndPrint(articles).forEach(System.out::println);

    }
    
    private static List<String> mapToTitle(List<Article> articles){
        return articles.stream().map(Article::title).collect(Collectors.toList());
    //      return articles.stream().map(article -> article.title()).collect(Collectors.toList());
    }

    private static List<String> mapToTitleAlternate(List<Article> articles){
        return articles.stream().map(article -> article.title().toUpperCase()).collect(Collectors.toList());
    }

    private static List<String> mapToTitleAndPrint(List<Article> articles){
      return articles.stream().map(article -> {
                  System.out.println("This article is written by: " +article.authorName());
                  return article.title();
      }
      ).collect(Collectors.toList());
    }

    private static record Article (int id, String title, String authorName){}

}
