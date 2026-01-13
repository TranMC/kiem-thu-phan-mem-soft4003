describe('Checkout Test', () => {
  beforeEach(() => {
    cy.login();
  });

  it('Kiểm thử hoàn thành quy trình thanh toán', () => {
    // Thêm sản phẩm vào giỏ hàng
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    
    // Đi đến trang giỏ hàng
    cy.get('.shopping_cart_link').click();
    cy.url().should('include', '/cart.html');
    
    // Nhấn nút Checkout
    cy.get('#checkout').click();
    cy.url().should('include', '/checkout-step-one.html');
    
    // Điền thông tin thanh toán
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    
    // Nhấn Continue
    cy.get('#continue').click();
    
    // Xác minh chuyển đến trang xác nhận
    cy.url().should('include', '/checkout-step-two.html');
  });
});
