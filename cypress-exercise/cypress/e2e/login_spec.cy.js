describe('Login Test', () => {
  it('Kiểm thử login đúng mật khẩu và đăng nhập thành công', () => {
    cy.visit('/');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.url().should('include', '/inventory.html');
    cy.screenshot('login-success');
  });

  it('Kiểm thử hiển thị thông báo lỗi với thông tin đăng nhập không hợp lệ', () => {
    cy.visit('/');
    cy.get('#user-name').type('invalid_user');
    cy.get('#password').type('wrong_password');
    cy.get('#login-button').click();
    cy.get('.error-message-container').should('contain', 'Username and password do not match');
    cy.screenshot('login-failed');
  });
});
