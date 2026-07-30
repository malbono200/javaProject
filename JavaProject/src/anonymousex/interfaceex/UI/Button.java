package anonymousex.interfaceex.UI;

public class Button {
	OnclickListener listener; //인터페이스타입
	public void setListener(OnclickListener listener) {
		this.listener = listener;
	}

	void touch() {
		listener.onClick();
	}

	//중첩인터페이스
	interface OnclickListener {
		void onClick();
	}
}
