package com.unit2.observer.inter;

public interface Subject {
	//ע��һ���۲���
	public void registObserver(Observer observer);
	//ɾ��һ���۲���
	public void removeObserver(Observer observer);
	//�������ù۲���
	public void notifyObservers();
	
	
	
}
