Hello Mentor!

I just wanted to cheer you up and ask you to be critical yet generous with your feedback. 
I am aware that my project is far from ideal, and while I have enough competence to acknowledge it, 
I don't have the skills to fix it completely. I hope to improve my abilities with your assistance.

Thank you!

// Things to improve:
// add additional unit tests or separate to small tests
// delete test  from emailPage
// our main service test depends on email service

Things to discuss on the call:
1. I am aware that actions with tabs should not be in Pages. 
That's why I attempted to implement them in a separate utility class called 'Tab.' 
However, it didn't work due to a 'NullPointerException' because 'this.driver' is null.
2. I understand that Pages should not contain any tests. 
Therefore, I tried to add a separate class called 'EstimateModal' as a component. 
However, it resulted in a 'NullPointerException' when calling 
'estimateModal.checkPriceIsCalculated(totalEstimateCostTxt).'
3. I attempted to write locators in the following format, as it is more logically correct and would be useful for scaling. 
It worked when I tried it in a separate test, but didn't work in the 'CalculatorPage' class.
Said that data.seriesValue has to be constant, however it was final
driver.findElement(By.xpath("//*[@id='select_value_label_93']")).click();
driver.findElement(By.xpath("//md-option[.//div[normalize-space(text())='" + data.seriesValue + "']]")).click();

And many more questions, so I can't wait for our meeting  

