package Bank_sytem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_main {
	// �û�
	List<Person> mes = new ArrayList<Person>();
	// ����
	ArrayList<Integer> ckid_Array = new ArrayList<Integer>();

	// ��������
	public void creatAdmin() {
		Scanner in = new Scanner(System.in);
		System.out.print("��ѡ����ǿ���ҵ��,");
		System.out.println("���������˻�����");
		String name_ = in.next();
		//ȡֵ��Χ�ļ��д��
		Integer id_ = (int) (Math.random() * 90000 + 10000);
		
		// �жϿ������Ƿ��ص�   ���Ǹ�����
		/*if (ckid_Array.contains(id_)) {
			//System.out.println(ckid_Array.size());
			
			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				
				// System.out.println(obj.getId());
				if (id_.equals(obj.getId())) {
					System.out.println("�û��Ѿ����ڣ�������ѡ��");
					
				} else {
					ckid_Array.add(id_);
					
					System.out.println("���μ�����Ϊ��׼���ľ����˺�:" + id_);
					continue;
				}
			}

		} else {
			System.out.println("�˺ſ�������ʹ��");
		}*/
		     
		
		
		ckid_Array.add(id_);
		System.out.println("���μ�����Ϊ��׼���ľ����˺�:" + id_);
		
		System.out.println("��������Ҫ����Ľ�");
		Long money_ = in.nextLong();
		
		Person p = new Person(id_, name_, money_);
		System.out.println(p.toString());
		
		mes.add(p);
	}

	// ��Ǯ�ķ���
	public void saveMoney() {
		System.out.print("��ѡ����Ǵ��ҵ��");
		System.out.println("���������Ŀ��ţ�");
		Scanner in = new Scanner(System.in);
		Integer id_c = in.nextInt();

		// �жϿ����Ǵ���
		if (ckid_Array.contains(id_c)) {
			System.out.println("�û�����");

			System.out.println(ckid_Array.size());
			
			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				
				// System.out.println(obj.getId());
				if (id_c.equals(obj.getId())) {
					System.out.println("��������Ҫ��Ľ��:");
					Long money_c = in.nextLong();
					
					Long monye_y = obj.getMoney();
					Long new_money = money_c + monye_y;
					
					obj.setMoney(new_money);
					System.out.println("������Ϊ��" + new_money);
				} else {
					continue;
				}
			}

		} else {
			System.out.println("�û�������");
		}
	}

	// ȡ���
	public void drawMoney() {
		System.out.println("��ѡ�����ȡ��ҵ��");
		System.out.println("���������Ŀ��ţ�");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		Integer id_c = in.nextInt();

		if (ckid_Array.contains(id_c)) {

			System.out.println("�û�����");

			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);

				if (id_c.equals(obj.getId())) {
					System.out.println("��������Ҫȡ�Ľ��:");
					Long money_q = in.nextLong();

					Long monye_y = obj.getMoney();
					
					if (money_q > monye_y) {
						System.out.println("����");
					} else {
						Long new_money = monye_y - money_q;
						obj.setMoney(new_money);
						System.out.println("������Ϊ��" + new_money);
					}

				} else {
					continue;
				}
			}
		} else {
			System.out.println("�û�������");
		}
	}

	// ת�˷���
	public void transforAcount() {
		System.out.print("��ѡ�����ת��ҵ��");
		System.out.println("��������ת���Ŀ��ţ�");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		Integer id_zmy = in.nextInt();
		System.out.println("��������Ҫת��Ŀ��ţ�");
		Integer id_zyou = in.nextInt();

		// �����жϿ����Ƿ����
		if (ckid_Array.contains(id_zmy) && ckid_Array.contains(id_zyou)) {

			System.out.println("�û�����");
			Long money_zhuan = null;// ת�˵Ľ���ʼΪnull;

			// ת���˵�ҵ��
			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				if (id_zmy.equals(obj.getId())) {
					System.out.println("��������Ҫת�Ľ��:");
					
					boolean flag=true;
					while(flag) {			
					money_zhuan = in.nextLong();
					// ��ȡת���˵�ǰ�Ľ��
					Long monye_zy = obj.getMoney();
					// �жϵ�ǰ����Ƿ����ת��
					if (money_zhuan > monye_zy) {
						System.out.println("����,����������");					
					} else {
						Long new_money = monye_zy - money_zhuan;
						obj.setMoney(new_money);
						System.out.println("������Ϊ��" + new_money);
						flag=false;
						break;
				
					}
				}

				} else {
					continue;
				}
			}

			// �տ��˵�ҵ��
			for (int j = 0; j < ckid_Array.size(); j++) {
				Person obj = (Person) mes.get(j);
				if (id_zyou.equals(obj.getId())) {
					Long monye_zy = obj.getMoney();
					Long new_money = money_zhuan + monye_zy;
					obj.setMoney(new_money);
				} else {
					continue;
				}
			}
		} else {
			System.out.println("�û�������");
		}
	}

	// ��ѯ���еķ���
	public void findAll() {
		System.out.println("��ѡ���ҵ���ǲ�ѯ");
		System.out.println(mes);
	}

	// ���˺Ų�ѯ�û���Ϣ�ķ���
	public void findById() {
		System.out.print("��ѡ����ǲ�ѯ������Ϣҵ��");
		System.out.println("���������Ŀ��ţ�");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		Integer id_c = in.nextInt();
		if (ckid_Array.contains(id_c)) {
			System.out.println("�û�����");

			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				if (id_c.equals(obj.getId())) {
					System.out.println(obj);
				} else {
					continue;
				}
			}
		} else {
			System.out.println("�û�������,��ѯʧ��");
		}
	}

	public static void main(String[] args) {
		Bank_main bm = new Bank_main();
		System.out.println("*******��ӭ��������ϵͳ����ѡ����Ҫ�����ҵ��*******");

		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print(
					"1-����" + "****" + "2-���" + "****" + "3-ȡ��" + "****" + "4-ת��" + "****" + "5-��ѯ" + "****" + "6-��ѯȫ��");

			int item = in.nextInt();

			if (item == 1) {
				// ����ҵ��
				bm.creatAdmin();
			} else if (item == 2) {
				// ���ҵ��
				bm.saveMoney();
			}

			else if (item == 3) {
				// ȡ��ҵ��
				bm.drawMoney();

			} else if (item == 4) {
				// ת��ҵ��
				bm.transforAcount();
			} else if (item == 5) {
				// ��ѯ�����û���Ϣ
				bm.findById();
			} else if (item == 6) {
				// ��ѯȫ��
				bm.findAll();
			} else {
				System.out.println("�����������������ѡ��");
			}
		}
	}
}
