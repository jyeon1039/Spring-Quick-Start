package polymorphism;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리...");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public SamsungTV() {
		System.out.println("===> SamsungTV) 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");	
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다");	
	}

	@Override
	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
}
