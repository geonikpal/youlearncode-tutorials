import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamFilterExample {

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

        Article sqlLike = new Article(
                3,
                "SQL LIKE Operator Tutorial",
                "Ignis Dei"
        );

        Article mathRandom = new Article(
                4,
                "Math.random Java Tutorial",
                "Georgios - Nikolaos Palaiologopoulos"
        );

        Article swiftForLoop = new Article(
                5,
                "Swift For Loop Tutorial",
                "Dimitris Tasios"
        );


        List<Article> articles = Arrays.asList(forLoop, interfaceTutorial, sqlLike, mathRandom, swiftForLoop);

        System.out.println("Print articles of Georgios - Nikolaos Palaiologopoulos: ");
        filterByAuthorName(articles, "Georgios - Nikolaos Palaiologopoulos").forEach(System.out::println);
        System.out.println();

        System.out.println("Print articles containing Java and Author Dimitris Tasios: ");
        filterIfContainsJavaAndAuthorTasios(articles).forEach(System.out::println);
        System.out.println();

        System.out.println("Print articles of Ignis Dei:");
        filterByAuthorIsIgnis(articles).forEach(System.out::println);

    }

    private static List<Article> filterByAuthorName(List<Article> articles, String author){
        return articles.stream()
                .filter(article -> article.authorName().equals(author))
                .collect(Collectors.toList());
    }

    private static List<Article> filterByAuthorIsIgnis(List<Article> articles){
        return articles.stream()
                .filter(Article::isIgnis)
                .collect(Collectors.toList());
    }


    private static List<Article> filterIfContainsJavaAndAuthorTasios(List<Article> articles){
        return articles.stream().filter(article -> {
                   boolean containsJava = article.title().contains("Java");
                   boolean isTasios = article.authorName().equals("Dimitris Tasios");
                   return containsJava && isTasios;
                }
        ).collect(Collectors.toList());
    }

    private static record Article (int id, String title, String authorName){
        private static boolean isIgnis(Article article){
            return article.authorName().equals("Ignis Dei");
        }
    }

}
