from re import M
import alpaca_trade_api as tradeapi
from alpaca_trade_api.rest import AccountActivities

# secure import
import config

# Martingale Strategy
class Martingale(object):
    def __init__(self):
        self.key = config.api_key
        self.secret = config.api_secret
        self.alpaca_endpoint = config.endpoint
        self.api = tradeapi.REST(self.key, self.secret, self.alpaca_endpoint)
        self.symbol = 'IVV'
        self.current_order = None
        self.last_price = 1

        try:
            self.position = int(self.api.get_position(self.symbol).qty)
        except:
            self.position = 0

    # Function: send an order - param: target quantity 
    def submit_order(self, target):
        # limit order amount - if an order exists, close it.
        if self.current_order is not None:
            self.api.cancel_order(self.current_order.id)

        delta = target - self.position
        if delta == 0:
            return
        print(f'Processing the Order for {target} shares')
        

        if delta > 0:
            buy_quantity = delta
            if self.position < 0:
                buy_quantity = min(abs(self.position), buy_quantity)
            print(f'Buying {buy_quantity} shares')
            self.current_order = self.api.submit_order(self.symbol, buy_quantity, 'buy', 'limit', 'day', self.last_price)


        elif delta < 0:
            sell_quantity = abs(delta)
            if self.position > 0:
                sell_quantity = min(abs(self.position), sell_quantity)
            print(f'selling {sell_quantity} shares')
            self.current_order = self.api.submit_order(self.symbol, sell_quantity, 'sell', 'limit', 'day', self.last_price)



if __name__ == '__main__':
    t = Martingale()
    t.submit_order(-1) 








# trading strategy (paper trading)












