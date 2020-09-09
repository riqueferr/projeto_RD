var InputManager = /** @class */ (function () {
    function InputManager(htmlInputElement) {
        this.htmlInputElement = htmlInputElement;
    }
    InputManager.prototype.setCursorAt = function (position) {
        if (this.htmlInputElement.setSelectionRange) {
            this.htmlInputElement.focus();
            this.htmlInputElement.setSelectionRange(position, position);
        }
        else if (this.htmlInputElement.createTextRange) {
            var textRange = this.htmlInputElement.createTextRange();
            textRange.collapse(true);
            textRange.moveEnd("character", position);
            textRange.moveStart("character", position);
            textRange.select();
        }
    };
    InputManager.prototype.updateValueAndCursor = function (newRawValue, oldLength, selectionStart) {
        this.rawValue = newRawValue;
        var newLength = newRawValue.length;
        selectionStart = selectionStart - (oldLength - newLength);
        this.setCursorAt(selectionStart);
    };
    Object.defineProperty(InputManager.prototype, "canInputMoreNumbers", {
        get: function () {
            var onlyNumbers = this.rawValue.replace(/[^0-9\u0660-\u0669\u06F0-\u06F9]/g, "");
            var haventReachedMaxLength = !(onlyNumbers.length >= this.htmlInputElement.maxLength && this.htmlInputElement.maxLength >= 0);
            var selectionStart = this.inputSelection.selectionStart;
            var selectionEnd = this.inputSelection.selectionEnd;
            var haveNumberSelected = !!(selectionStart != selectionEnd &&
                this.htmlInputElement.value.substring(selectionStart, selectionEnd).match(/[^0-9\u0660-\u0669\u06F0-\u06F9]/));
            var startWithZero = (this.htmlInputElement.value.substring(0, 1) == "0");
            return haventReachedMaxLength || haveNumberSelected || startWithZero;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(InputManager.prototype, "inputSelection", {
        get: function () {
            var selectionStart = 0;
            var selectionEnd = 0;
            if (typeof this.htmlInputElement.selectionStart == "number" && typeof this.htmlInputElement.selectionEnd == "number") {
                selectionStart = this.htmlInputElement.selectionStart;
                selectionEnd = this.htmlInputElement.selectionEnd;
            }
            else {
                var range = document.selection.createRange();
                if (range && range.parentElement() == this.htmlInputElement) {
                    var lenght = this.htmlInputElement.value.length;
                    var normalizedValue = this.htmlInputElement.value.replace(/\r\n/g, "\n");
                    var startRange = this.htmlInputElement.createTextRange();
                    startRange.moveToBookmark(range.getBookmark());
                    var endRange = this.htmlInputElement.createTextRange();
                    endRange.collapse(false);
                    if (startRange.compareEndPoints("StartToEnd", endRange) > -1) {
                        selectionStart = selectionEnd = lenght;
                    }
                    else {
                        selectionStart = -startRange.moveStart("character", -lenght);
                        selectionStart += normalizedValue.slice(0, selectionStart).split("\n").length - 1;
                        if (startRange.compareEndPoints("EndToEnd", endRange) > -1) {
                            selectionEnd = lenght;
                        }
                        else {
                            selectionEnd = -startRange.moveEnd("character", -lenght);
                            selectionEnd += normalizedValue.slice(0, selectionEnd).split("\n").length - 1;
                        }
                    }
                }
            }
            return {
                selectionStart: selectionStart,
                selectionEnd: selectionEnd
            };
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(InputManager.prototype, "rawValue", {
        get: function () {
            return this.htmlInputElement && this.htmlInputElement.value;
        },
        set: function (value) {
            this._storedRawValue = value;
            if (this.htmlInputElement) {
                this.htmlInputElement.value = value;
            }
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(InputManager.prototype, "storedRawValue", {
        get: function () {
            return this._storedRawValue || '';
        },
        enumerable: false,
        configurable: true
    });
    return InputManager;
}());
export { InputManager };
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaW5wdXQubWFuYWdlci5qcyIsInNvdXJjZVJvb3QiOiJuZzovL25neC1jdXJyZW5jeS8iLCJzb3VyY2VzIjpbInNyYy9pbnB1dC5tYW5hZ2VyLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBSUksc0JBQW9CLGdCQUFxQjtRQUFyQixxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQUs7SUFDekMsQ0FBQztJQUVELGtDQUFXLEdBQVgsVUFBWSxRQUFnQjtRQUN4QixJQUFJLElBQUksQ0FBQyxnQkFBZ0IsQ0FBQyxpQkFBaUIsRUFBRTtZQUN6QyxJQUFJLENBQUMsZ0JBQWdCLENBQUMsS0FBSyxFQUFFLENBQUM7WUFDOUIsSUFBSSxDQUFDLGdCQUFnQixDQUFDLGlCQUFpQixDQUFDLFFBQVEsRUFBRSxRQUFRLENBQUMsQ0FBQztTQUMvRDthQUFNLElBQUksSUFBSSxDQUFDLGdCQUFnQixDQUFDLGVBQWUsRUFBRTtZQUM5QyxJQUFJLFNBQVMsR0FBRyxJQUFJLENBQUMsZ0JBQWdCLENBQUMsZUFBZSxFQUFFLENBQUM7WUFDeEQsU0FBUyxDQUFDLFFBQVEsQ0FBQyxJQUFJLENBQUMsQ0FBQztZQUN6QixTQUFTLENBQUMsT0FBTyxDQUFDLFdBQVcsRUFBRSxRQUFRLENBQUMsQ0FBQztZQUN6QyxTQUFTLENBQUMsU0FBUyxDQUFDLFdBQVcsRUFBRSxRQUFRLENBQUMsQ0FBQztZQUMzQyxTQUFTLENBQUMsTUFBTSxFQUFFLENBQUM7U0FDdEI7SUFDTCxDQUFDO0lBRUQsMkNBQW9CLEdBQXBCLFVBQXFCLFdBQW1CLEVBQUUsU0FBaUIsRUFBRSxjQUFzQjtRQUMvRSxJQUFJLENBQUMsUUFBUSxHQUFHLFdBQVcsQ0FBQztRQUM1QixJQUFJLFNBQVMsR0FBRyxXQUFXLENBQUMsTUFBTSxDQUFDO1FBQ25DLGNBQWMsR0FBRyxjQUFjLEdBQUcsQ0FBQyxTQUFTLEdBQUcsU0FBUyxDQUFDLENBQUM7UUFDMUQsSUFBSSxDQUFDLFdBQVcsQ0FBQyxjQUFjLENBQUMsQ0FBQztJ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Q0FBQyxVQUFVLEVBQUUsUUFBUSxDQUFDLEdBQUcsQ0FBQyxDQUFDLEVBQUU7NEJBQ3hELFlBQVksR0FBRyxNQUFNLENBQUM7eUJBQ3pCOzZCQUFNOzRCQUNILFlBQVksR0FBRyxDQUFDLFVBQVUsQ0FBQyxPQUFPLENBQUMsV0FBVyxFQUFFLENBQUMsTUFBTSxDQUFDLENBQUM7NEJBQ3pELFlBQVksSUFBSSxlQUFlLENBQUMsS0FBSyxDQUFDLENBQUMsRUFBRSxZQUFZLENBQUMsQ0FBQyxLQUFLLENBQUMsSUFBSSxDQUFDLENBQUMsTUFBTSxHQUFHLENBQUMsQ0FBQzt5QkFDakY7cUJBQ0o7aUJBQ0o7YUFDSjtZQUVELE9BQU87Z0JBQ0gsY0FBYyxFQUFFLGNBQWM7Z0JBQzlCLFlBQVksRUFBRSxZQUFZO2FBQzdCLENBQUM7UUFDTixDQUFDOzs7T0FBQTtJQUVELHNCQUFJLGtDQUFRO2FBQVo7WUFDSSxPQUFPLElBQUksQ0FBQyxnQkFBZ0IsSUFBSSxJQUFJLENBQUMsZ0JBQWdCLENBQUMsS0FBSyxDQUFDO1FBQ2hFLENBQUM7YUFFRCxVQUFhLEtBQWE7WUFDdEIsSUFBSSxDQUFDLGVBQWUsR0FBRyxLQUFLLENBQUM7WUFFN0IsSUFBSSxJQUFJLENBQUMsZ0JBQWdCLEVBQUU7Z0JBQ3ZCLElBQUksQ0FBQyxnQkFBZ0IsQ0FBQyxLQUFLLEdBQUcsS0FBSyxDQUFDO2FBQ3ZDO1FBQ0wsQ0FBQzs7O09BUkE7SUFVRCxzQkFBSSx3Q0FBYzthQUFsQjtZQUNJLE9BQU8sSUFBSSxDQUFDLGVBQWUsSUFBSSxFQUFFLENBQUM7UUFDdEMsQ0FBQzs7O09BQUE7SUFDTCxtQkFBQztBQUFELENBQUMsQUE3RkQsSUE2RkMiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgY2xhc3MgSW5wdXRNYW5hZ2VyIHtcblxuICAgIHByaXZhdGUgX3N0b3JlZFJhd1ZhbHVlOiBzdHJpbmc7XG5cbiAgICBjb25zdHJ1Y3Rvcihwcml2YXRlIGh0bWxJbnB1dEVsZW1lbnQ6IGFueSkge1xuICAgIH1cblxuICAgIHNldEN1cnNvckF0KHBvc2l0aW9uOiBudW1iZXIpOiB2b2lkIHtcbiAgICAgICAgaWYgKHRoaXMuaHRtbElucHV0RWxlbWVudC5zZXRTZWxlY3Rpb25SYW5nZSkge1xuICAgICAgICAgICAgdGhpcy5odG1sSW5wdXRFbGVtZW50LmZvY3VzKCk7XG4gICAgICAgICAgICB0aGlzLmh0bWxJbnB1dEVsZW1lbnQuc2V0U2VsZWN0aW9uUmFuZ2UocG9zaXRpb24sIHBvc2l0aW9uKTtcbiAgICAgICAgfSBlbHNlIGlmICh0aGlzLmh0bWxJbnB1dEVsZW1lbnQuY3JlYXRlVGV4dFJhbmdlKSB7XG4gICAgICAgICAgICBsZXQgdGV4dFJhbmdlID0gdGhpcy5odG1sSW5wdXRFbGVtZW50LmNyZWF0ZVRleHRSYW5nZSgpO1xuICAgICAgICAgICAgdGV4dFJhbmdlLmNvbGxhcHNlKHRydWUpO1xuICAgICAgICAgICAgdGV4dFJhbmdlLm1vdmVFbmQoXCJjaGFyYWN0ZXJcIiwgcG9zaXRpb24pO1xuICAgICAgICAgICAgdGV4dFJhbmdlLm1vdmVTdGFydChcImNoYXJhY3RlclwiLCBwb3NpdGlvbik7XG4gICAgICAgICAgICB0ZXh0UmFuZ2Uuc2VsZWN0KCk7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICB1cGRhdGVWYWx1ZUFuZEN1cnNvcihuZXdSYXdWYWx1ZTogc3RyaW5nLCBvbGRMZW5ndGg6IG51bWJlciwgc2VsZWN0aW9uU3RhcnQ6IG51bWJlcik6IHZvaWQge1xuICAgICAgICB0aGlzLnJhd1ZhbHVlID0gbmV3UmF3VmFsdWU7XG4gICAgICAgIGxldCBuZXdMZW5ndGggPSBuZXdSYXdWYWx1ZS5sZW5ndGg7XG4gICAgICAgIHNlbGVjdGlvblN0YXJ0ID0gc2VsZWN0aW9uU3RhcnQgLSAob2xkTGVuZ3RoIC0gbmV3TGVuZ3RoKTtcbiAgICAgICAgdGhpcy5zZXRDdXJzb3JBdChzZWxlY3Rpb25TdGFydCk7XG4gICAgfVxuXG4gICAgZ2V0IGNhbklucHV0TW9yZU51bWJlcnMoKTogYm9vbGVhbiB7XG4gICAgICAgIGxldCBvbmx5TnVtYmVycyA9IHRoaXMucmF3VmFsdWUucmVwbGFjZSgvW14wLTlcXHUwNjYwLVxcdTA2NjlcXHUwNkYwLVxcdTA2RjldL2csIFwiXCIpO1xuICAgICAgICBsZXQgaGF2ZW50UmVhY2hlZE1heExlbmd0aCA9ICEob25seU51bWJlcnMubGVuZ3RoID49IHRoaXMuaHRtbElucHV0RWxlbWVudC5tYXhMZW5ndGggJiYgdGhpcy5odG1sSW5wdXRFbGVtZW50Lm1heExlbmd0aCA+PSAwKTtcbiAgICAgICAgbGV0IHNlbGVjdGlvblN0YXJ0ID0gdGhpcy5pbnB1dFNlbGVjdGlvbi5zZWxlY3Rpb25TdGFydDtcbiAgICAgICAgbGV0IHNlbGVjdGlvbkVuZCA9IHRoaXMuaW5wdXRTZWxlY3Rpb24uc2VsZWN0aW9uRW5kO1xuICAgICAgICBsZXQgaGF2ZU51bWJlclNlbGVjdGVkID0gISEoc2VsZWN0aW9uU3RhcnQgIT0gc2VsZWN0aW9uRW5kICYmXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB0aGlzLmh0bWxJbnB1dEVsZW1lbnQudmFsdWUuc3Vic3RyaW5nKHNlbGVjdGlvblN0YXJ0LCBzZWxlY3Rpb25FbmQpLm1hdGNoKC9bXjAtOVxcdTA2NjAtXFx1MDY2OVxcdTA2RjAtXFx1MDZGOV0vKSk7XG4gICAgICAgIGxldCBzdGFydFdpdGhaZXJvID0gKHRoaXMuaHRtbElucHV0RWxlbWVudC52YWx1ZS5zdWJzdHJpbmcoMCwgMSkgPT0gXCIwXCIpO1xuICAgICAgICByZXR1cm4gaGF2ZW50UmVhY2hlZE1heExlbmd0aCB8fCBoYXZlTnVtYmVyU2VsZWN0ZWQgfHwgc3RhcnRXaXRoWmVybztcbiAgICB9XG5cbiAgICBnZXQgaW5wdXRTZWxlY3Rpb24oKTogYW55IHtcbiAgICAgICAgbGV0IHNlbGVjdGlvblN0YXJ0ID0gMDtcbiAgICAgICAgbGV0IHNlbGVjdGlvbkVuZCA9IDA7XG5cbiAgICAgICAgaWYgKHR5cGVvZiB0aGlzLmh0bWxJbnB1dEVsZW1lbnQuc2VsZWN0aW9uU3RhcnQgPT0gXCJudW1iZXJcIiAmJiB0eXBlb2YgdGhpcy5odG1sSW5wdXRFbGVtZW50LnNlbGVjdGlvbkVuZCA9PSBcIm51bWJlclwiKSB7XG4gICAgICAgICAgICBzZWxlY3Rpb25TdGFydCA9IHRoaXMuaHRtbElucHV0RWxlbWVudC5zZWxlY3Rpb25TdGFydDtcbiAgICAgICAgICAgIHNlbGVjdGlvbkVuZCA9IHRoaXMuaHRtbElucHV0RWxlbWVudC5zZWxlY3Rpb25FbmQ7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBsZXQgcmFuZ2UgPSAoPGFueT5kb2N1bWVudCkuc2VsZWN0aW9uLmNyZWF0ZVJhbmdlKCk7XG5cbiAgICAgICAgICAgIGlmIChyYW5nZSAmJiByYW5nZS5wYXJlbnRFbGVtZW50KCkgPT0gdGhpcy5odG1sSW5wdXRFbGVtZW50KSB7XG4gICAgICAgICAgICAgICAgbGV0IGxlbmdodCA9IHRoaXMuaHRtbElucHV0RWxlbWVudC52YWx1ZS5sZW5ndGg7XG4gICAgICAgICAgICAgICAgbGV0IG5vcm1hbGl6ZWRWYWx1ZSA9IHRoaXMuaHRtbElucHV0RWxlbWVudC52YWx1ZS5yZXBsYWNlKC9cXHJcXG4vZywgXCJcXG5cIik7XG4gICAgICAgICAgICAgICAgbGV0IHN0YXJ0UmFuZ2UgPSB0aGlzLmh0bWxJbnB1dEVsZW1lbnQuY3JlYXRlVGV4dFJhbmdlKCk7XG4gICAgICAgICAgICAgICAgc3RhcnRSYW5nZS5tb3ZlVG9Cb29rbWFyayhyYW5nZS5nZXRCb29rbWFyaygpKTtcbiAgICAgICAgICAgICAgICBsZXQgZW5kUmFuZ2UgPSB0aGlzLmh0bWxJbnB1dEVsZW1lbnQuY3JlYXRlVGV4dFJhbmdlKCk7XG4gICAgICAgICAgICAgICAgZW5kUmFuZ2UuY29sbGFwc2UoZmFsc2UpO1xuXG4gICAgICAgICAgICAgICAgaWYgKHN0YXJ0UmFuZ2UuY29tcGFyZUVuZFBvaW50cyhcIlN0YXJ0VG9FbmRcIiwgZW5kUmFuZ2UpID4gLTEpIHtcbiAgICAgICAgICAgICAgICAgICAgc2VsZWN0aW9uU3RhcnQgPSBzZWxlY3Rpb25FbmQgPSBsZW5naHQ7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgc2VsZWN0aW9uU3RhcnQgPSAtc3RhcnRSYW5nZS5tb3ZlU3RhcnQoXCJjaGFyYWN0ZXJcIiwgLWxlbmdodCk7XG4gICAgICAgICAgICAgICAgICAgIHNlbGVjdGlvblN0YXJ0ICs9IG5vcm1hbGl6ZWRWYWx1ZS5zbGljZSgwLCBzZWxlY3Rpb25TdGFydCkuc3BsaXQoXCJcXG5cIikubGVuZ3RoIC0gMTtcblxuICAgICAgICAgICAgICAgICAgICBpZiAoc3RhcnRSYW5nZS5jb21wYXJlRW5kUG9pbnRzKFwiRW5kVG9FbmRcIiwgZW5kUmFuZ2UpID4gLTEpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHNlbGVjdGlvbkVuZCA9IGxlbmdodDtcbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHNlbGVjdGlvbkVuZCA9IC1zdGFydFJhbmdlLm1vdmVFbmQoXCJjaGFyYWN0ZXJcIiwgLWxlbmdodCk7XG4gICAgICAgICAgICAgICAgICAgICAgICBzZWxlY3Rpb25FbmQgKz0gbm9ybWFsaXplZFZhbHVlLnNsaWNlKDAsIHNlbGVjdGlvbkVuZCkuc3BsaXQoXCJcXG5cIikubGVuZ3RoIC0gMTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuXG4gICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICBzZWxlY3Rpb25TdGFydDogc2VsZWN0aW9uU3RhcnQsXG4gICAgICAgICAgICBzZWxlY3Rpb25FbmQ6IHNlbGVjdGlvbkVuZFxuICAgICAgICB9O1xuICAgIH1cblxuICAgIGdldCByYXdWYWx1ZSgpOiBzdHJpbmcge1xuICAgICAgICByZXR1cm4gdGhpcy5odG1sSW5wdXRFbGVtZW50ICYmIHRoaXMuaHRtbElucHV0RWxlbWVudC52YWx1ZTtcbiAgICB9XG5cbiAgICBzZXQgcmF3VmFsdWUodmFsdWU6IHN0cmluZykge1xuICAgICAgICB0aGlzLl9zdG9yZWRSYXdWYWx1ZSA9IHZhbHVlO1xuXG4gICAgICAgIGlmICh0aGlzLmh0bWxJbnB1dEVsZW1lbnQpIHtcbiAgICAgICAgICAgIHRoaXMuaHRtbElucHV0RWxlbWVudC52YWx1ZSA9IHZhbHVlO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgZ2V0IHN0b3JlZFJhd1ZhbHVlKCk6IHN0cmluZyB7XG4gICAgICAgIHJldHVybiB0aGlzLl9zdG9yZWRSYXdWYWx1ZSB8fCAnJztcbiAgICB9XG59XG4iXX0=