package interfaceex.extend;

public class ImplementationC implements InterfaceC {
	
	@Override
	public void methodB() {
		 System.out.println("CImplClass의 methodA()실행");		
	}

	@Override
	public void methodA() {
		 System.out.println("CImplClass의 methodB()실행");		
	}

	@Override
	public void methodC() {
		 System.out.println("CImplClass의 methodC()실행");		
	}
}
