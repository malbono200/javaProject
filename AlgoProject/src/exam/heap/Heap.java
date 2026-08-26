package exam.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
	
	private int size; //요소 개수
	
	private Object[] array; // 요소를 담을 배열
	
	///생성자 Type 1 (초기 공간 할당 X)
	public Heap() { 
		this(null);
	}
	
	public Heap(Comparator <? super E> comparator) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}
	
	//받은 인덱스의 부모 노드 인덱스 계산 반환
	private int getParent(int index) {
		return index/2;
	}
	
	//받은 인덱스의 왼쪽 자식 노드 인덱스 계산 반환
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	//받은 인덱스의 오른쪽 자식 노드 인덱스 계산 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	// 생성자 Type 2 (초기 공간 할당 O)
	public Heap(int capacity) {
		this(capacity, null);
	}
	
	public Heap(int capacity,  Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this. comparator = comparator;
	}
	
	/// resize
	/// 새로운 용량은 파라미터로 받는다
	
	private void resize(int newCapacity) {
		//배열 새로 생성
		Object[] newArray = new Object[newCapacity];
		
		//새 배열에 기존에 있던 배열 요소들을 모두 복사 함
		for(int i=1; i <= size; i++) {
			newArray[i] = array[i];
		}
		
		/// 기존 배열 객체 연결 끊고(null) 새 배열 연결
		
		this. array = null;
		this. array = newArray;
	}
	
	/// heap에 자료 저장 -> add(target) -> shiftUp(size, target(저장할값))
	
	public void add(E value) {
		//배열이 꽉 차있을경우 현재 크기의 두배로 확장
		if(size + 1 == array. length) {
			resize(array.length * 2);
		}
		//인덱스 계산을 위해 배열은 1번 idx부터 사용
		shiftUp(size + 1, value);//추가되는 위치와 넣을 값을 전달
		size++; //정상적으로 추가 후 재배치가 끝나면 사이즈를 증가
	}
	
	/// idx : 추가위치, target : 저자할 값
	
	private void shiftUp(int idx, E target) {
		if(comparator != null) {
			shiftUpComparator(idx, target, comparator);
		}else {
			shiftUpComparable(idx, target);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftUpComparator(int idx, E target, Comparator <? super E> comp) {
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; //부모노드 값 추출

			//타겟노드값(기준)과 부모노드값 비교 : 1 또는 0은 기준객체가 더 큼
			if(comp.compare(target, (E)parentVal)<= 0) {
				//교환필요 없이 현재 위치에 저장
				break;
			};
			// 비교 결과가 음수면
			// 부모노드가 타켓 노드보다 크면
			// 현재 위치의 값을 부모노드값으로 교체 타겟 노드 위치를 부모노드 위치로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		//반복을 종료하면 target의 최종 위치가 정해짐 : idx
		array[idx] = target;
	}
	
	@SuppressWarnings("unchecked")
	private void shiftUpComparable(int idx, E target) {
		//Comparable 사용위해 기준객체 타입을 Comparable 타입으로 형변환
		Comparable <? super E> comp = (Comparable <? super E>)target;
		
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; //부모노드 값 추출

			//타겟노드값(기준)과 부모노드값 비교 : 1 또는 0은 기준객체가 더 큼
			if(comp.compareTo((E)parentVal) <= 0) {
				//교환필요 없이 현재 위치에 저장
				break;
			};
			// 비교 결과가 음수면
			// 부모노드가 타켓 노드보다 크면
			// 현재 위치의 값을 부모노드값으로 교체 타겟 노드 위치를 부모노드 위치로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		//반복을 종료하면 target의 최종 위치가 정해짐 : idx
		array[idx] = comp;
	}
	
	/// remove 메서드
	/// heap은 root 노드를 삭제함
	/// root 노드 삭제 후 heap 재구성
	/// remove() -> shiftDown(idx, target)
	
	public E remove() {
		if(array[1] == null) {
			throw new NoSuchElementException();
		}
		
		E result = (E)array[1];
		E target; //타겟이 될 요소
		if(size == 1) {
			target = null;
		} else {
			target = (E)array[size];
		}
		
		array[size] = null ; //마지막 노드 삭제
		
		//root가 삭제되므로 heap 재구성
		shiftDown(1, target); //재배치할 타겟 노드

		return result;
	}
	
	/**
	 * @param idx	삭제할 노드의 인덱스 
	 * @param target	재배치 할 노드
	 */
	
	private void shiftDown(int idx, E target) {
		if(comparator != null) {
			shiftDownComparator(idx, target, comparator);
		} else {
			shiftDownComparable(idx, target);
		}
	}
	
	// Comparator을 이용한 sift-down
	@SuppressWarnings("unchecked")
	private void shiftDownComparator(int idx, E target, Comparator <? super E> comp) {
		//삭제할 index의 노드를 삭제
		array[idx] = null; // 삭제 할 인덱스의 노드를 삭제
		size--;

		int parent = idx; // 삭제노드부터 시작 할 부모를 가리키는 변수
		int child; // 교환 될 자식을 가리키는 변수
		
		// 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
		while((child = getLeftChild(parent)) <= size) {
			
			int right = getRightChild(parent); // 오른쪽 자식 인덱스
			
			Object childVal = array[child]; // 왼쪽 자식의 값 (교환 될 값)
			
			if(right <= size && comp.compare((E)childVal, (E) array[right]) < 0) {
				child = right;
				childVal = array[child];
			}
			
			if(comp.compare(target ,(E) childVal) >= 0){
				break;
			}
			
			/*
			 *  현재 부모 인덱스에 자식 노드 값을 대체해주고 
			 *  부모 인덱스를 자식 인덱스로 교체
			 */
			array[parent] = childVal;
			parent = child;
		}
		
		// 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
		array[parent] = target;
		
		/*
		 *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우 
		 *  용적을 반으로 줄임(단, 최소용적보단 커야함)
		 */
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}
	
	// Comparable을 이용한 sift-down
	@SuppressWarnings("unchecked")
	private void shiftDownComparable(int idx, E target) {
		
		Comparable<? super E> comp = (Comparable<? super E>) target;		
		array[idx] = null;
		size--;
		
		int parent = idx;
		int child; 		
		
		while((child = getLeftChild(parent)) <= size) {
			
			int right = getRightChild(parent);
			
			Object childVal = array[child];
		
			if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) < 0) {
				child = right;
				childVal = array[child];
			}
			
			if(comp.compareTo((E) childVal) >= 0){
				break;
			}
			array[parent] = childVal;
			parent = child;
			
		}
		array[parent] = comp;
		
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}		
	}
	
	public int size() {
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(array[1] == null) {
			throw new NoSuchElementException();
		}
		
		return (E)array[1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
    
	public Object[] toArray() {
		return Arrays.copyOf(array, size + 1);
	}
	
	public E[] sort(E[] arr) {
		System.out.println("초기 배열 상태: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			this.add(arr[i]);
			System.out.println(arr[i] + " 추가 후 힙 상태: " + Arrays.toString(this.toArray()));
		}
		
		System.out.println("\n정렬 시작");
		
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = this.remove();
			System.out.println("최댓값 " + arr[i] + " 추출 및 정렬 후 배열 상태: " + Arrays.toString(arr));
		}
		System.out.println("정렬 완료\n");
		
		return arr;
	}
}
