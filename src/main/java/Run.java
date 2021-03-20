
class Run {

    //psvm for test purposes

    public static void main(String[] args) {
        OpenWeatherService openWeatherService = new OpenWeatherService();
        System.out.println(openWeatherService.connectAndFetchWindSpeed());
    }
}
