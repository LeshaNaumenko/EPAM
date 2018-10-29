package practice5.task1.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ClassRegister {

    private List<Record> recordList = new ArrayList<>();

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public boolean addRecord(String name, String surname, String patronymic, GregorianCalendar birth, String phone, Address address){

        for (Record record : recordList) {
            if (record.getName().equals(name)&&record.getSurname().equals(surname)&&record.getPatronymic().equals(patronymic)){
                return false;
            }
        }
        recordList.add(new Record(name,surname,patronymic,birth,phone,address));
        return true;

    }

    class Record {
        private String name;
        private String surname;
        private String patronymic;
        private GregorianCalendar birth = new GregorianCalendar();
        private String phone;
        private Address address;

        public Record() {
        }

        public Record(String name, String surname, String patronymic, GregorianCalendar birth, String phone, Address address) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.birth = birth;
            this.phone = phone;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public GregorianCalendar getBirth() {
            return birth;
        }

        public void setBirth(GregorianCalendar birth) {
            this.birth = birth;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Record record = (Record) o;

            if (name != null ? !name.equals(record.name) : record.name != null) return false;
            if (surname != null ? !surname.equals(record.surname) : record.surname != null) return false;
            if (patronymic != null ? !patronymic.equals(record.patronymic) : record.patronymic != null) return false;
            if (birth != null ? !birth.equals(record.birth) : record.birth != null) return false;
            if (phone != null ? !phone.equals(record.phone) : record.phone != null) return false;
            return address != null ? address.equals(record.address) : record.address == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (surname != null ? surname.hashCode() : 0);
            result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
            result = 31 * result + (birth != null ? birth.hashCode() : 0);
            result = 31 * result + (phone != null ? phone.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
            return "Record{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", patronymic='" + patronymic + '\'' +
                    ", birth={" + dateFormat.format(birth.getTime()) +
                    "}, phone='" + phone + '\'' +
                    ", address=" + address +
                    '}';
        }
    }

    public static void main(String[] args) {


        GregorianCalendar g = new GregorianCalendar(1999, Calendar.DECEMBER, 18);
        System.out.println(g.getTime());

    }
}
