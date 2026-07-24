package exam;

public class Reservation {
	String flightName;
    String passengerName;
    String departure;
    String destination;
    int price;
    String seatNo;

    public Reservation(String flightName, String passengerName, String departure, String destination, int price, String seatNo) {
        this.flightName = flightName;
        this.passengerName = passengerName;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.seatNo = seatNo;
    }
        
    public void showRsvInfo() {
        System.out.println("**항공권 예약 정보**");
        System.out.println("항공기 : " + flightName);
        System.out.println("예약자 : " + passengerName);
        System.out.println("출발지 : " + departure);
        System.out.println("도착지 : " + destination);
        System.out.println("금액 : " + price);
        System.out.println("좌석번호 : " + seatNo);
    }
}
