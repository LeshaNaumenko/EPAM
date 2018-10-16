package practice3.task2.model;

import practice3.task2.model.entity.Goods;

import java.util.*;

public class Shop {
    private static int counter = 1;
    private String name;
    private List<Department> listOfDepartments = new LinkedList<>();
    private Set<Integer> listOfLocation = new TreeSet<Integer>();
    private Department tempDepForAddingGoods;

    {
        listOfLocation.add(1);
        listOfLocation.add(3);
        listOfLocation.add(2);

    }


    public Set<Integer> getListOfLocation() {
        return listOfLocation;
    }

    public List<Department> getListOfDepartments() {
        return listOfDepartments;
    }

    public boolean hasDepartment(String name) {
        for (Department dp : listOfDepartments) {
            if (dp.name.equals(name)) {
                tempDepForAddingGoods = dp;
                return true;
            }
        }
        return false;
    }

    public boolean deleteLocation(Integer loc) {
        Iterator<Integer> it = listOfLocation.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next == loc) {
                it.remove();
                for (Department item : listOfDepartments) {
                    if (item.getLocation() == loc) {
                        item.setLocation(null);
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean addNewLocation(Integer location) {
        for (Integer item : listOfLocation) {
            if (item == location) {
                return true;
            }
        }
        listOfLocation.add(location);
        return false;


    }


    public boolean alreadyExists(Integer location) {
        for (Department item : listOfDepartments) {
            if (item.getLocation().equals(location)) {
                return true;
            }
        }
        return false;
    }

    public boolean addNewDepartment(String name, String typeOfGoods, Integer location, List<String> listOfServices) {
        Department department = new Department(name, typeOfGoods, location, listOfServices);
        for (Department dep : listOfDepartments) {
            if (department.equals(dep)) {
                return false;
            }
        }
        listOfDepartments.add(department);
        listOfLocation.add(location);
        return true;
    }

    public boolean eliminateTheDepartment(String name) {
        Iterator<Department> it = listOfDepartments.iterator();
        while (it.hasNext()) {
            Department next = it.next();
            if (next.name.equals(name)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean addGoodsForDepartment(List<Goods> goods) {
        if (goods.isEmpty()) return false;
        tempDepForAddingGoods.addGoods(goods);
        return true;
    }

    public List<Goods> getGoodsOfDepartment(String s1) {
        for (Department dep : listOfDepartments) {
            if (s1.equals(dep.name)) {
                return dep.getGoods();
            }
        }
        return null;
    }


    public boolean reallocation() {
        if (listOfLocation.size() >= listOfDepartments.size()) {
            listOfDepartments.sort(new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return Integer.compare(o2.getGoods().size(), o1.getGoods().size() );
                }
            });
            Iterator<Integer> it = listOfLocation.iterator();

            Integer current = 0;
            int temp = 0;
            while (it.hasNext()&& temp < listOfDepartments.size()) {
                current = it.next();
                listOfDepartments.get(temp).setLocation(current);
                temp++;
            }
            return true;
        } else
            return false;
    }

    private class Department {
        private int id = counter++;
        private String name;
        private String typeOfGoods;
        private Integer location;
        private List<String> listOfServices = new ArrayList<>();
        private List<Goods> goods = new ArrayList<>();

        public List<Goods> getGoods() {
            return goods;
        }

        public void setGoods(List<Goods> goods) {
            this.goods = goods;
        }

        public void addGoods(List<Goods> goods) {
            this.goods.addAll(goods);
        }

        public void addOneItem(List<Goods> item) {
            if (!goods.isEmpty()) {
                this.goods.addAll(item);
            }
        }

        public Department(String name, String typeOfGoods, Integer location, List<String> listOfServices) {
            this.name = name;
            this.typeOfGoods = typeOfGoods;
            this.location = location;
            this.listOfServices = listOfServices;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTypeOfGoods() {
            return typeOfGoods;
        }

        public void setTypeOfGoods(String typeOfGoods) {
            this.typeOfGoods = typeOfGoods;
        }

        public Integer getLocation() {
            return location;
        }

        public void setLocation(Integer location) {
            this.location = location;
        }

        public List<String> getListOfServices() {
            return listOfServices;
        }

        public void setListOfServices(List<String> listOfServices) {
            this.listOfServices = listOfServices;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", typeOfGoods='" + typeOfGoods + '\'' +
                    ", location='" + location + '\'' +
                    ", listOfServices=" + listOfServices +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Department that = (Department) o;

            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            if (typeOfGoods != null ? !typeOfGoods.equals(that.typeOfGoods) : that.typeOfGoods != null) return false;
            return location != null ? location.equals(that.location) : that.location == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (typeOfGoods != null ? typeOfGoods.hashCode() : 0);
            result = 31 * result + (location != null ? location.hashCode() : 0);
            return result;
        }
    }
}
