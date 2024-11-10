var expect = require("chai").expect;
var temp = 3.6;
var test = function() {
	return 1;
};

describe("app test", () => {
	it("should be 1", () => {
		expect(test()).to.be.equal(1);
	});
});
