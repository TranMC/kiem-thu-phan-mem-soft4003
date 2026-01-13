describe('Cart Test', () => {
  beforeEach(() => {
    cy.login();
  });

  it('Kiểm thử thêm sản phẩm vào giỏ hàng', () => {
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    cy.screenshot('cart-add-product');
  });

  it('Kiểm thử sắp xếp sản phẩm theo giá từ thấp đến cao', () => {
    cy.get('.product_sort_container').select('lohi');
    cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    cy.screenshot('cart-sort-price-low-to-high');
  });

  it('Kiểm thử xóa sản phẩm khỏi giỏ hàng', () => {
    // Thêm sản phẩm vào giỏ hàng
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    
    // Xóa sản phẩm khỏi giỏ hàng
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('not.exist');
  });
});
