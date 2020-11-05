package action;

import bean.Product;

/**
 * @Classname ProductAction
 * @Description TODO
 * @Date 2020/10/31 16:24
 * @Created by Administrator
 */
public class ProductAction {
    private Product product;
    public String show(){
        product=new Product();
        product.setName("iphone7");
        return "show";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String add()  {
        System.out.println("product.name:"+product.getName());
        return "show";
    }
}
