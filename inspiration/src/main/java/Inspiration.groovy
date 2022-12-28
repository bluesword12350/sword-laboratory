/**
 * @author 李林峰
 */
class Inspiration {
    static void main(String[] args) throws URISyntaxException, IOException {
        URL piUrl = ClassLoader.getSystemResource("PI.txt")
        assert piUrl != null
        def piInput = new File(piUrl.toURI())
        System.out.println(piInput.text)
    }
}
