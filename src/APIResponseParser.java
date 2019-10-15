public class APIResponseParser {

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        String titleStartRule = "<title>";
        String title = parse(response, titleStartRule, endRule);
        book.setTitle(title);

        String authorStartRule = "<author>";
        String author = parse(response, authorStartRule, endRule);
        book.setAuthor(author);

        String pubStartRule = "<original_publication_year>";
        String publicationYear = parse(response, pubStartRule, endRule);
        book.setPublicationYear(Integer.parseInt(publicationYear));

        String averageRatingStartRule = "<average_rating>";
        String averageRating = parse(response, averageRatingStartRule, endRule);
        book.setAverageRating(Double.parseDouble(averageRating));

        String ratingsCountStartRule = "<ratings_count type=\"integer\">";
        String ratingsCount = parse(response, ratingsCountStartRule, endRule);
        book.setRatingsCount(Integer.parseInt(ratingsCount.replaceAll(",", "")));

        String imageURLStartRule = "<image_url>";
        String imageURL = parse(response, imageURLStartRule, endRule);
        book.setImageUrl(imageURL);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int beginLocation = response.indexOf(startRule);
        boolean alreadyCalculated = startRule.equals("<name>");
        String subResponse = response.substring(beginLocation + startRule.length());
        String authorSubStartRule = "<name>";

//        if (startRule.equals("<author>")) {
        if (startRule.equals("<author>") || alreadyCalculated) { // dheeru
                if (alreadyCalculated) {
                int endLocation = subResponse.indexOf(endRule);
                return subResponse.substring(0, endLocation);
            } ;

            String author = parse(subResponse, authorSubStartRule, endRule);
        }

        int endLocation = subResponse.indexOf(endRule);
//        return subResponse.substring(0, endLocation);
        return parse(subResponse, authorSubStartRule, endRule); // dheeru
    }


    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        APIResponseParser.parse(response);
    }
}