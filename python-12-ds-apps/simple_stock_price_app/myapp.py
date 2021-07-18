import streamlit as st
import yfinance as yf
import pandas as pd


# header of web application
# '#'h1 '##'h2
st.write("""
# Simple Stock Price App
Shown are the Stock **Closing Price** and ***volume*** of Google!
""")

# refernce: towardsdatascience.com/how-to-get-stack-data-using-python
# # define the ticker symbol


# tickerSymbol = 'GOOGL'
in_sym = st.text_input('Enter the Symbol: ')
tickerSymbol = in_sym
# get the data on this ticker
tickerData = yf.Ticker(tickerSymbol)

# retrieve historical GOOGL stock prices for this ticker
tickerDf = tickerData.history(period='id', start='2010-07-16', end='2021-07-16')
# columns
# Open | High | Low | Close | Volume | Dividens | Stock Splits

st.line_chart(tickerDf.Close)
st.line_chart(tickerDf.Volume)

st.write("""
test: 
""")
tickerDf.Close


